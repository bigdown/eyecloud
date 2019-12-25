package com.qding.eyecloud.video.remote.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.BatchBindTemplateRequest;
import com.aliyuncs.vs.model.v20181212.BatchBindTemplateResponse;
import com.aliyuncs.vs.model.v20181212.BatchUnbindTemplateRequest;
import com.aliyuncs.vs.model.v20181212.BatchUnbindTemplateResponse;
import com.aliyuncs.vs.model.v20181212.BindTemplateRequest;
import com.aliyuncs.vs.model.v20181212.BindTemplateResponse;
import com.aliyuncs.vs.model.v20181212.CreateTemplateRequest;
import com.aliyuncs.vs.model.v20181212.CreateTemplateResponse;
import com.aliyuncs.vs.model.v20181212.DeleteTemplateRequest;
import com.aliyuncs.vs.model.v20181212.DeleteTemplateResponse;
import com.aliyuncs.vs.model.v20181212.DescribeTemplateRequest;
import com.aliyuncs.vs.model.v20181212.DescribeTemplateResponse;
import com.aliyuncs.vs.model.v20181212.DescribeTemplatesRequest;
import com.aliyuncs.vs.model.v20181212.DescribeTemplatesResponse;
import com.aliyuncs.vs.model.v20181212.ModifyTemplateRequest;
import com.aliyuncs.vs.model.v20181212.ModifyTemplateResponse;
import com.aliyuncs.vs.model.v20181212.UnbindTemplateRequest;
import com.aliyuncs.vs.model.v20181212.UnbindTemplateResponse;

/**
 * 阿里云视频监控--模板操作接口工具类
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoTemplateUtil {
    
    /**
     * 绑定模板到指定的多个实例，比如绑定到空间和流的实例
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchBindTemplateResponse batchBindTemplate(DefaultProfile profile,
        BatchBindTemplateRequest request) {
        BatchBindTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 解除绑定模板到指定的多个实例，比如解除绑定到空间和流的实例
     * 模板id和类型至少指定一个
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchUnbindTemplateResponse batchUnbindTemplate(DefaultProfile profile,
        BatchUnbindTemplateRequest request) {
        BatchUnbindTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 绑定模板到指定的实例，比如绑定到空间和流的实例
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BindTemplateResponse bindTemplate(DefaultProfile profile, BindTemplateRequest request) {
        BindTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 创建新模板
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static CreateTemplateResponse createTemplate(DefaultProfile profile, CreateTemplateRequest request) {
        CreateTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 删除模板
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DeleteTemplateResponse deleteTemplate(DefaultProfile profile, DeleteTemplateRequest request) {
        DeleteTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查询模板信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeTemplateResponse describeTemplate(DefaultProfile profile, DescribeTemplateRequest request) {
        DescribeTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查询模板列表
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeTemplatesResponse describeTemplates(DefaultProfile profile,
        DescribeTemplatesRequest request) {
        DescribeTemplatesResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 修改模板信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static ModifyTemplateResponse modifyTemplate(DefaultProfile profile, ModifyTemplateRequest request) {
        ModifyTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 解除绑定模板到指定的实例，比如解除绑定到空间和流的实例
     * 模板id和类型至少指定一个
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static UnbindTemplateResponse unbindTemplate(DefaultProfile profile, UnbindTemplateRequest request) {
        UnbindTemplateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
}
