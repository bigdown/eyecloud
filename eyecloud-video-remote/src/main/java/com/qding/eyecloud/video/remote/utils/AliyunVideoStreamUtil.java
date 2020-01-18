package com.qding.eyecloud.video.remote.utils;

import com.aliyuncs.vs.model.v20181212.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 阿里云视频监控--流操作相关接口工具类
 * <功能详细描述>
 * @since [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年10月14日
 */
public class AliyunVideoStreamUtil {

    /**
     * 获取流URL信息
     * <功能详细描述>
     * @param request
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static DescribeStreamURLResponse describeStreamUrl(DescribeStreamURLRequest request) {
        return (DescribeStreamURLResponse)AliyunCoreUtil.core(request);
    }

    /**
     * 启动流
     * <功能详细描述>
     * @param streamId
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StartStreamResponse startStream(String streamId) {
        StartStreamRequest request = new StartStreamRequest();
        request.setId(streamId);
        return (StartStreamResponse)AliyunCoreUtil.core(request);
    }

    /**
     * Desc:对指定流，按需创建新的截图
     * Info:<功能详细描述>
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * Date:2019/12/30 13:49
     */
    public static String createStreamSnapshot(String streamId) {
        String snapshotUrl = StringUtils.EMPTY;
        CreateStreamSnapshotRequest request = new CreateStreamSnapshotRequest();
        request.setId(streamId);
        CreateStreamSnapshotResponse response = (CreateStreamSnapshotResponse)AliyunCoreUtil.core(request);
        if (!Objects.isNull(response)) {
            snapshotUrl = response.getUrl();
        }
        return snapshotUrl;
    }

    /**
     * 停止流
     * <功能详细描述>
     * @param streamId
     * @return
     * @since [产品/模块版本]
     * @author tanshen@qding.me
     * @version v1.0
     * @Date: 2019年10月15日
     */
    public static StopStreamResponse stopStream(String streamId) {
        StopStreamRequest request = new StopStreamRequest();
        request.setId(streamId);
        return (StopStreamResponse)AliyunCoreUtil.core(request);
    }

}
