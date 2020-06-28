package com.t.s.eyecloud.common.log.filter;

import com.t.s.eyecloud.common.constants.EyecloudConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.t.s.eyecloud.common.utils.SnowFlake;
import com.t.s.eyecloud.common.utils.TraceIdUtils;

/**
 * Description: traceId的记录filter
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月9日
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER}, value = "tracelog")
public class TraceLogFilter implements Filter {
    
    private static final Logger logger = LoggerFactory.getLogger(TraceLogFilter.class);
    
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation)
        throws RpcException {
        Long startTime = System.currentTimeMillis();
        RpcContext rpcContext = RpcContext.getContext();
        String traceId = rpcContext.getAttachment(EyecloudConstants.TRACE_ID);
        if (StringUtils.isNotBlank(traceId)) {
            // 从RpcContext里获取traceId并保存
            TraceIdUtils.setTraceId(traceId);
        } else {
            // 交互前重新设置traceId, 避免信息丢失
            traceId = TraceIdUtils.getTraceId();
            
            // 如果获取到的也为空，则说明不是从request那边过来的
            if (StringUtils.isBlank(traceId)) {
                traceId = "dubbo:" + SnowFlake.createSnowFlake().nextIdString();
            }
            RpcContext.getContext().setAttachment(EyecloudConstants.TRACE_ID, traceId);
        }
        MDC.put(EyecloudConstants.TRACE_ID, traceId);
        
        Object[] args = invocation.getArguments();
        String methodName = invoker.getInterface().getSimpleName() + "." + invocation.getMethodName();
        
        if (logger.isDebugEnabled()) {
            logger.debug(
                "dubbo start <{}>, provider<{}>, consumer<{}>, local<{}>, remote<{}>, methodName<{}>, args<{}>",
                startTime,
                rpcContext.isProviderSide(),
                rpcContext.isConsumerSide(),
                rpcContext.getLocalHost(),
                rpcContext.getRemoteHost(),
                methodName,
                args);
        }
        
        Result result = invoker.invoke(invocation);
        
        if (result.hasException()) {
            // 调用出错的时候输出
            logger.error("dubbo invoke error <{}>", result.getException().getMessage());
        } else {
            if (rpcContext.isConsumerSide()) {
                logger.info("dubbo facade:<{}>, params:<{}>, result:<{}>", methodName, args, result);
            }
        }
        Long endTime = System.currentTimeMillis();
        if (logger.isDebugEnabled()) {
            logger.debug("dubbo end <{}>,user <{}>ms", endTime, endTime - startTime);
        }
        
        if (rpcContext.isProviderSide()) {
            MDC.remove(EyecloudConstants.TRACE_ID);
        }
        return result;
    }
}
