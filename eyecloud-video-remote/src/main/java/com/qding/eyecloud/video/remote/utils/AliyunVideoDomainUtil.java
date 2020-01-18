//package com.qding.eyecloud.video.remote.utils;
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.vs.model.v20181212.BatchDeleteVsDomainConfigsRequest;
//import com.aliyuncs.vs.model.v20181212.BatchDeleteVsDomainConfigsResponse;
//import com.aliyuncs.vs.model.v20181212.BatchSetVsDomainConfigsRequest;
//import com.aliyuncs.vs.model.v20181212.BatchSetVsDomainConfigsResponse;
//import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateDetailRequest;
//import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateDetailResponse;
//import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateListRequest;
//import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateListResponse;
//import com.aliyuncs.vs.model.v20181212.DescribeVsDomainConfigsRequest;
//import com.aliyuncs.vs.model.v20181212.DescribeVsDomainConfigsResponse;
//import com.aliyuncs.vs.model.v20181212.DescribeVsDomainDetailRequest;
//import com.aliyuncs.vs.model.v20181212.DescribeVsDomainDetailResponse;
//import com.aliyuncs.vs.model.v20181212.SetVsDomainCertificateRequest;
//import com.aliyuncs.vs.model.v20181212.SetVsDomainCertificateResponse;
//import com.qding.qdh.framework.cache.ServiceResultCodeCache;
//import com.qding.qdh.framework.model.ServiceResult;
//
///**
// * 阿里云视频监控--域名相关操作工具类
// * <功能详细描述>
// * @since  [产品/模块版本]
// * @author tanshen@qding.me
// * @version v1.0
// * @Date: 2019年10月14日
// */
//public class AliyunVideoDomainUtil {
//
//	private static ServiceResultCodeCache resultCode = ServiceResultCodeCache.getInstance();
//
//	/**
//	 * 域名删除域名配置
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<BatchDeleteVsDomainConfigsResponse> batchDeleteVsDomainConfigs(DefaultProfile profile,
//			BatchDeleteVsDomainConfigsRequest request) {
//		ServiceResult<BatchDeleteVsDomainConfigsResponse> result = new ServiceResult<>();
//		BatchDeleteVsDomainConfigsResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//	/**
//	 * 域名批量配置
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<BatchSetVsDomainConfigsResponse> batchSetVsDomainConfigs(DefaultProfile profile,
//			BatchSetVsDomainConfigsRequest request) {
//		ServiceResult<BatchSetVsDomainConfigsResponse> result = new ServiceResult<>();
//		BatchSetVsDomainConfigsResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//	/**
//	 * 获取证书详细信息
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<DescribeVsCertificateDetailResponse> describeVsCertificateDetail(DefaultProfile profile,
//			DescribeVsCertificateDetailRequest request) {
//		ServiceResult<DescribeVsCertificateDetailResponse> result = new ServiceResult<>();
//		DescribeVsCertificateDetailResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//	/**
//	 * 获取证书列表信息
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<DescribeVsCertificateListResponse> describeVsCertificateList(DefaultProfile profile,
//			DescribeVsCertificateListRequest request) {
//		ServiceResult<DescribeVsCertificateListResponse> result = new ServiceResult<>();
//		DescribeVsCertificateListResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//	/**
//	 * 查询域名配置，一次可查询过个功能配置
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<DescribeVsDomainConfigsResponse> describeVsDomainConfigs(DefaultProfile profile,
//			DescribeVsDomainConfigsRequest request) {
//		ServiceResult<DescribeVsDomainConfigsResponse> result = new ServiceResult<>();
//		DescribeVsDomainConfigsResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//	/**
//	 * 获取指定视频监控域名配置的基本信息
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<DescribeVsDomainDetailResponse> describeVsDomainDetail(DefaultProfile profile,
//			DescribeVsDomainDetailRequest request) {
//		ServiceResult<DescribeVsDomainDetailResponse> result = new ServiceResult<>();
//		DescribeVsDomainDetailResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//	/**
//	 * 该接口用于设置某域名下证书功能是否启用及 修改证书信息
//	 * <功能详细描述>
//	 * @param profile
//	 * @param request
//	 * @return
//	 * @since  [产品/模块版本]
//	 * @author tanshen@qding.me
//	 * @version v1.0
//	 * @Date: 2019年10月15日
//	 */
//	public static ServiceResult<SetVsDomainCertificateResponse> setVsDomainCertificate(DefaultProfile profile,
//			SetVsDomainCertificateRequest request) {
//		ServiceResult<SetVsDomainCertificateResponse> result = new ServiceResult<>();
//		SetVsDomainCertificateResponse response = null;
//		IAcsClient client = new DefaultAcsClient(profile);
//		try {
//			response = client.getAcsResponse(request);
//			result.setObj(response);
//			result.setCode(resultCode.get("common.sucess"));
//			result.setMsg(resultCode.getMsgZh("common.sucess"));
//		} catch (ServerException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		} catch (ClientException e) {
//			result.setCode(resultCode.get("common.fail"));
//			result.setMsg(e.getErrMsg());
//		}
//		return result;
//	}
//
//}
