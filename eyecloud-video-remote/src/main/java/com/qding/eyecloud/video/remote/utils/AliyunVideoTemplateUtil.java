//package com.qding.eyecloud.video.remote.utils;
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.vs.model.v20181212.BatchBindTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.BatchBindTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.BatchUnbindTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.BatchUnbindTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.BindTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.BindTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.CreateTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.CreateTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.DeleteTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.DeleteTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.DescribeTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.DescribeTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.DescribeTemplatesRequest;
//import com.aliyuncs.vs.model.v20181212.DescribeTemplatesResponse;
//import com.aliyuncs.vs.model.v20181212.ModifyTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.ModifyTemplateResponse;
//import com.aliyuncs.vs.model.v20181212.UnbindTemplateRequest;
//import com.aliyuncs.vs.model.v20181212.UnbindTemplateResponse;
//import com.qding.qdh.framework.cache.ServiceResultCodeCache;
//import com.qding.qdh.framework.model.ServiceResult;
//
///**
// * 阿里云视频监控--模板操作接口工具类
// * <功能详细描述>
// * @since  [产品/模块版本]
// * @author tanshen@qding.me
// * @version v1.0
// * @Date: 2019年10月14日
// */
//public class AliyunVideoTemplateUtil {
//
//    private static ServiceResultCodeCache resultCode = ServiceResultCodeCache.getInstance();
//
//    /**
//     * 绑定模板到指定的多个实例，比如绑定到空间和流的实例
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<BatchBindTemplateResponse> batchBindTemplate(DefaultProfile profile,
//        BatchBindTemplateRequest request) {
//        ServiceResult<BatchBindTemplateResponse> result = new ServiceResult<>();
//        BatchBindTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 解除绑定模板到指定的多个实例，比如解除绑定到空间和流的实例
//     * 模板id和类型至少指定一个
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<BatchUnbindTemplateResponse> batchUnbindTemplate(DefaultProfile profile,
//        BatchUnbindTemplateRequest request) {
//        ServiceResult<BatchUnbindTemplateResponse> result = new ServiceResult<>();
//        BatchUnbindTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 绑定模板到指定的实例，比如绑定到空间和流的实例
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<BindTemplateResponse> bindTemplate(DefaultProfile profile,
//        BindTemplateRequest request) {
//        ServiceResult<BindTemplateResponse> result = new ServiceResult<>();
//        BindTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 创建新模板
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<CreateTemplateResponse> createTemplate(DefaultProfile profile,
//        CreateTemplateRequest request) {
//        ServiceResult<CreateTemplateResponse> result = new ServiceResult<>();
//        CreateTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 删除模板
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<DeleteTemplateResponse> deleteTemplate(DefaultProfile profile,
//        DeleteTemplateRequest request) {
//        ServiceResult<DeleteTemplateResponse> result = new ServiceResult<>();
//        DeleteTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 查询模板信息
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<DescribeTemplateResponse> describeTemplate(DefaultProfile profile,
//        DescribeTemplateRequest request) {
//        ServiceResult<DescribeTemplateResponse> result = new ServiceResult<>();
//        DescribeTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 查询模板列表
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<DescribeTemplatesResponse> describeTemplates(DefaultProfile profile,
//        DescribeTemplatesRequest request) {
//        ServiceResult<DescribeTemplatesResponse> result = new ServiceResult<>();
//        DescribeTemplatesResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 修改模板信息
//     * <功能详细描述>
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<ModifyTemplateResponse> modifyTemplate(DefaultProfile profile,
//        ModifyTemplateRequest request) {
//        ServiceResult<ModifyTemplateResponse> result = new ServiceResult<>();
//        ModifyTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//
//    /**
//     * 解除绑定模板到指定的实例，比如解除绑定到空间和流的实例
//     * 模板id和类型至少指定一个
//     * @param profile
//     * @param request
//     * @return
//     * @since  [产品/模块版本]
//     * @author tanshen@qding.me
//     * @version v1.0
//     * @Date: 2019年10月15日
//     */
//    public static ServiceResult<UnbindTemplateResponse> unbindTemplate(DefaultProfile profile,
//        UnbindTemplateRequest request) {
//        ServiceResult<UnbindTemplateResponse> result = new ServiceResult<>();
//        UnbindTemplateResponse response = null;
//        IAcsClient client = new DefaultAcsClient(profile);
//        try {
//            response = client.getAcsResponse(request);
//            result.setObj(response);
//            result.setCode(resultCode.get("common.sucess"));
//            result.setMsg(resultCode.getMsgZh("common.sucess"));
//        } catch (ServerException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        } catch (ClientException e) {
//            result.setCode(resultCode.get("common.fail"));
//            result.setMsg(e.getErrMsg());
//        }
//        return result;
//    }
//}
