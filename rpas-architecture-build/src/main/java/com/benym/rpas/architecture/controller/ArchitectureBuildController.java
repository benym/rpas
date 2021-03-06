package com.benym.rpas.architecture.controller;

import com.benym.rpas.architecture.config.BaseProjectConfig;
import com.benym.rpas.architecture.pojo.FileVO;
import com.benym.rpas.architecture.service.BuildService;
import com.benym.rpas.common.dto.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2022/7/20 4:47 下午
 */
@RestController
@RequestMapping("/rpas")
public class ArchitectureBuildController {

    @Autowired
    private BuildService buildService;

    @ApiOperation("项目生成")
    @PostMapping("/build")
    public Response<FileVO> build(@RequestBody @Validated BaseProjectConfig baseProjectConfig) {
        FileVO fileVO = buildService.architectureBuild(baseProjectConfig);
        return Response.success(fileVO);
    }

    @ApiOperation("下载项目")
    @GetMapping("/download/{id}")
    public void download(@PathVariable("id") String id) {
        buildService.download(id);
    }

}
