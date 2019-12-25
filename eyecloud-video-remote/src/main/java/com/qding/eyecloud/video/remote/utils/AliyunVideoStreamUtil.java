package com.qding.eyecloud.video.remote.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.BatchStartStreamsRequest;
import com.aliyuncs.vs.model.v20181212.BatchStartStreamsResponse;
import com.aliyuncs.vs.model.v20181212.BatchStopStreamsRequest;
import com.aliyuncs.vs.model.v20181212.BatchStopStreamsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeRecordsRequest;
import com.aliyuncs.vs.model.v20181212.DescribeRecordsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeStreamRequest;
import com.aliyuncs.vs.model.v20181212.DescribeStreamResponse;
import com.aliyuncs.vs.model.v20181212.DescribeStreamURLRequest;
import com.aliyuncs.vs.model.v20181212.DescribeStreamURLResponse;
import com.aliyuncs.vs.model.v20181212.DescribeStreamsRequest;
import com.aliyuncs.vs.model.v20181212.DescribeStreamsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeVsStreamsOnlineListRequest;
import com.aliyuncs.vs.model.v20181212.DescribeVsStreamsOnlineListResponse;
import com.aliyuncs.vs.model.v20181212.DescribeVsStreamsPublishListRequest;
import com.aliyuncs.vs.model.v20181212.DescribeVsStreamsPublishListResponse;
import com.aliyuncs.vs.model.v20181212.ForbidVsStreamRequest;
import com.aliyuncs.vs.model.v20181212.ForbidVsStreamResponse;
import com.aliyuncs.vs.model.v20181212.ResumeVsStreamRequest;
import com.aliyuncs.vs.model.v20181212.ResumeVsStreamResponse;
import com.aliyuncs.vs.model.v20181212.StartStreamRequest;
import com.aliyuncs.vs.model.v20181212.StartStreamResponse;
import com.aliyuncs.vs.model.v20181212.StopStreamRequest;
import com.aliyuncs.vs.model.v20181212.StopStreamResponse;

/**
 * 阿里云视频监控--流操作相关接口工具类
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoStreamUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(AliyunVideoStreamUtil.class);
    
    /**
     * 批量启动流
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchStartStreamsResponse batchStartStreams(DefaultProfile profile,
        BatchStartStreamsRequest request) {
        BatchStartStreamsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 批量停止流
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchStopStreamsResponse batchStopStreams(DefaultProfile profile, BatchStopStreamsRequest request) {
        BatchStopStreamsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查看指定域名下（或者指定域名下某个应用）的所有正在推的流的信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeVsStreamsOnlineListResponse describeVsStreamsOnlineList(DefaultProfile profile,
        DescribeVsStreamsOnlineListRequest request) {
        DescribeVsStreamsOnlineListResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 获取某一时间段内某个域名(或域名下某应用或某个流)的推流记录
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeVsStreamsPublishListResponse describeVsStreamsPublishList(DefaultProfile profile,
        DescribeVsStreamsPublishListRequest request) {
        DescribeVsStreamsPublishListResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查询流信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeStreamResponse describeStream(DefaultProfile profile, DescribeStreamRequest request) {
        DescribeStreamResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查询流列表
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeStreamsResponse describeStreams(DefaultProfile profile, DescribeStreamsRequest request) {
        DescribeStreamsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 获取流URL信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeStreamURLResponse describeStreamUrl(DefaultProfile profile,
        DescribeStreamURLRequest request) {
        DescribeStreamURLResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            logger.error("获取流URL信息出错：{}", e.getMessage());
        } catch (ClientException e) {
            logger.error("获取流URL信息出错：{}", e.getMessage());
        }
        return response;
    }
    
    /**
     * 禁止某条流的推送，可以预设某个时刻将流恢复
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ForbidVsStreamResponse forbidVsStream(DefaultProfile profile, ForbidVsStreamRequest request) {
        ForbidVsStreamResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 恢复某条监控流的推送
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ResumeVsStreamResponse resumeVsStream(DefaultProfile profile, ResumeVsStreamRequest request) {
        ResumeVsStreamResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 启动流
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StartStreamResponse startStream(DefaultProfile profile, StartStreamRequest request) {
        StartStreamResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 停止流
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopStreamResponse stopStream(DefaultProfile profile, StopStreamRequest request) {
        StopStreamResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查询存储记录列表
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeRecordsResponse describeRecords(DefaultProfile profile, DescribeRecordsRequest request) {
        DescribeRecordsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
}
