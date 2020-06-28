package com.t.s.eyecloud.test;

import com.t.s.eyecloud.auth.remote.AuthRemoteApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthRemoteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class Redis {

}
