package com.diao.home.qiqi;

import java.util.List;

import com.diao.home.CommonService;
import com.diao.home.ResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * QiController
 */
@RestController
@RequestMapping("/qiqi")
public class QiController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private QiMapper qiMapper;

    /**
     * 保存图片
     * 
     * @param multiReq
     * @throws InterruptedException
     */
    @RequestMapping("/savePicInfo")
    public ResponseModel savePicInfoAction(MultipartHttpServletRequest multiReq) throws InterruptedException {
        List<String> picNameList = commonService.batchSaveFiles(multiReq.getFiles("file"), true);
        ResponseModel responseModel = new ResponseModel();
        Integer categoryId = Integer.parseInt(multiReq.getParameter("categoryId"));

        for (String var : picNameList) {
            QiPicModel qiModel = new QiPicModel();
            qiModel.setCategoryId(categoryId);
            qiModel.setPicName(var);
            qiMapper.savePic(qiModel);
        }
        Thread.sleep(2000);
        return responseModel;
    }

    /**
     * 查询图片
     * 
     * @param categoryId
     * @param start
     * @return
     */
    @RequestMapping("/queryPic")
    public ResponseModel queryPicAction(Integer categoryId, Integer page) {
        ResponseModel response = new ResponseModel();

        response.setData(qiMapper.queryPicInfo(categoryId, (page - 1) * 20));
        return response;
    }

    /**
     * 查询种类
     * 
     * @return
     */
    @RequestMapping("/queryCategory")
    public ResponseModel queryCategoryAction() {
        ResponseModel response = new ResponseModel();
        response.setData(qiMapper.queryAllCategory());
        return response;
    }
}