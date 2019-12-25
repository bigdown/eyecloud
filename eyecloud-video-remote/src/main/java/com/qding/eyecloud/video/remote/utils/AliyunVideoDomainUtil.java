package com.qding.eyecloud.video.remote.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vs.model.v20181212.BatchDeleteVsDomainConfigsRequest;
import com.aliyuncs.vs.model.v20181212.BatchDeleteVsDomainConfigsResponse;
import com.aliyuncs.vs.model.v20181212.BatchSetVsDomainConfigsRequest;
import com.aliyuncs.vs.model.v20181212.BatchSetVsDomainConfigsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateDetailRequest;
import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateDetailResponse;
import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateListRequest;
import com.aliyuncs.vs.model.v20181212.DescribeVsCertificateListResponse;
import com.aliyuncs.vs.model.v20181212.DescribeVsDomainConfigsRequest;
import com.aliyuncs.vs.model.v20181212.DescribeVsDomainConfigsResponse;
import com.aliyuncs.vs.model.v20181212.DescribeVsDomainDetailRequest;
import com.aliyuncs.vs.model.v20181212.DescribeVsDomainDetailResponse;
import com.aliyuncs.vs.model.v20181212.SetVsDomainCertificateRequest;
import com.aliyuncs.vs.model.v20181212.SetVsDomainCertificateResponse;

/**
 * 阿里云视频监控--域名相关操作工具类
 * <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoDomainUtil {
    
    /**
     * 域名删除域名配置
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchDeleteVsDomainConfigsResponse batchDeleteVsDomainConfigs(DefaultProfile profile,
        BatchDeleteVsDomainConfigsRequest request) {
        BatchDeleteVsDomainConfigsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 域名批量配置
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static BatchSetVsDomainConfigsResponse batchSetVsDomainConfigs(DefaultProfile profile,
        BatchSetVsDomainConfigsRequest request) {
        BatchSetVsDomainConfigsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 获取证书详细信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeVsCertificateDetailResponse describeVsCertificateDetail(DefaultProfile profile,
        DescribeVsCertificateDetailRequest request) {
        DescribeVsCertificateDetailResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 获取证书列表信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeVsCertificateListResponse describeVsCertificateList(DefaultProfile profile,
        DescribeVsCertificateListRequest request) {
        DescribeVsCertificateListResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 查询域名配置，一次可查询过个功能配置
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeVsDomainConfigsResponse describeVsDomainConfigs(DefaultProfile profile,
        DescribeVsDomainConfigsRequest request) {
        DescribeVsDomainConfigsResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 获取指定视频监控域名配置的基本信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeVsDomainDetailResponse describeVsDomainDetail(DefaultProfile profile,
        DescribeVsDomainDetailRequest request) {
        DescribeVsDomainDetailResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
    /**
     * 该接口用于设置某域名下证书功能是否启用及 修改证书信息
     * <功能详细描述>
     * @param profile
     * @param request
     * @return
     * @since  [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static SetVsDomainCertificateResponse setVsDomainCertificate(DefaultProfile profile,
        SetVsDomainCertificateRequest request) {
        SetVsDomainCertificateResponse response = null;
        IAcsClient client = new DefaultAcsClient(profile);
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
        } catch (ClientException e) {
        }
        return response;
    }
    
}
