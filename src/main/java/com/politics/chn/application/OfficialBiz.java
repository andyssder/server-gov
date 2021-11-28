package com.politics.chn.application;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.OfficialDO;
import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.user.dao.BaseUserDao;
import com.politics.chn.repo.user.dao.PermissionDao;
import com.politics.chn.repo.user.dao.RoleDao;
import com.politics.chn.service.official.OfficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

    public List<OfficialDO> getOfficialList() {
        return officialService.getAllOfficial();
    }

    public OfficialDO getOneOfficial(long id) {
        return officialService.getOfficialById(id);
    }

    public void addOfficial(OfficialDO official) {
        Assert.isTrue(official.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Assert.isTrue(officialService.addOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void updateOfficial(OfficialDO official) {
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


