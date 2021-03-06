package com.benym.rpas.architecture.service;

import com.benym.rpas.architecture.config.BaseProjectConfig;
import com.benym.rpas.architecture.pojo.FileVO;
import java.io.File;

/**
 * @date 2022/7/20 4:36 下午
 */
public interface BuildService {

    FileVO architectureBuild(BaseProjectConfig baseProjectConfig);

    void download(String id);

    void generate(File file, String templatesFtl, BaseProjectConfig baseProjectConfig);

}
