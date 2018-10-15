package com.exb.client.fileserviceclient.service.impl;


import com.exb.client.fileserviceclient.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceImplTest {

    @Autowired
    private FileService fileService;

    @Test
    public void exist() throws Exception {
        //given(fileService.exist("1234", "download.png")).willReturn(true);

        Boolean exist = fileService.exist("1234", "download.png");

        //verify(fileService, times(1)).exist("1234", "download.png");
       // assertThat(exist).isEqualTo(true);

    }







}