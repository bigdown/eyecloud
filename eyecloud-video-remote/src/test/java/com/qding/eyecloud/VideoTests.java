package com.qding.eyecloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qding.eyecloud.common.data.response.video.VideoPreviewVO;
import com.qding.eyecloud.video.facade.IAliVideoFacade;
import com.qding.eyecloud.video.remote.VideoRemoteApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VideoRemoteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class VideoTests {
    
    @Autowired
    private IAliVideoFacade iAliVideoFacade;
    
    @Test
    public void getDevicePreviewUrlTest() {
        VideoPreviewVO request = new VideoPreviewVO();
//        request.setId("125182239918127169-cn-shanghai");
        request.setId("130239427611062406-cn-shanghai");
        request.setOutProtocol("hls");
        request.setAuthKey("np5X49HIXHoyzAHz");
        request.setExpire(120L);
        String previewUrl = iAliVideoFacade.getDevicePreviewUrl(request);
        System.out.println(previewUrl);
    }
}
