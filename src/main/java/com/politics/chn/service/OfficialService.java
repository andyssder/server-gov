package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.OfficialDO;
import com.politics.chn.repo.repository.OfficialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 14:12
 */
@Service
public class OfficialService {
    private OfficialRepository officialRepository;

    @Autowired
    private void setOfficialRepository(OfficialRepository officialRepository) {
        this.officialRepository = officialRepository;
    }

    public List<OfficialDO> getOfficialList() {
        return officialRepository.getAllOfficial();
    }

    public OfficialDO getOneOfficial(long id) {
        return officialRepository.getOfficialById(id);
    }

    public void addOfficial(OfficialDO official) {
        Assert.isTrue(official.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Assert.isTrue(officialRepository.addOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void updateOfficial(OfficialDO official) {
        Assert.isTrue(officialRepository.updateOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void deleteOfficial(long id) {
        Assert.isTrue(officialRepository.deleteOfficial(id), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }
}
