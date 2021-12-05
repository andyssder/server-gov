package com.politics.chn.application;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.Official;
import com.politics.chn.service.official.OfficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@Service
public class OfficialBiz {
    private OfficialService officialService;

    @Autowired
    private void setOfficialService(OfficialService officialService) {
        this.officialService = officialService;
    }

    public List<Official> getOfficialList() {
        return officialService.getAllOfficial();
    }

    public Official getOneOfficial(long id) {
        return officialService.getOfficialById(id);
    }

    public void addOfficial(Official official) {
        Assert.isTrue(official.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Assert.isTrue(officialService.addOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void updateOfficial(Official official) {
        Assert.isTrue(officialService.updateOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void deleteOfficial(long id) {
        Assert.isTrue(officialService.deleteOfficial(id), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }
}


