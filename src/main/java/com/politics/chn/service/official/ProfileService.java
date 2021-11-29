package com.politics.chn.service.official;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.ProfileDO;
import com.politics.chn.repo.official.po.ProfilePO;
import com.politics.chn.repo.official.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-11-28
 */
@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public boolean addOne(ProfileDO profileDO) {
        return profileRepository.addOne(profileDO);
    }

    public boolean addMany(List<ProfileDO> profileDOS) {
        if (profileDOS == null || profileDOS.isEmpty()) {
            return true;
        }

        return profileRepository.addMany(profileDOS);
    }

    public boolean deleteOne(long id) {
        return profileRepository.deleteOne(id) ;
    }

    public boolean deleteOneByPersonId(long id) {
        return profileRepository.deleteOneByPersonId(id);
    }

    public boolean updateOne(ProfileDO profileDO) {
        return profileRepository.updateOne(profileDO);
    }

    public boolean updateMany(List<ProfileDO> profileDOS) {
        if (profileDOS == null || profileDOS.isEmpty()) {
            return true;
        }
        return profileRepository.updateMany(profileDOS);
    }

    public List<ProfileDO> getAll() {
        List<ProfilePO> list = profileRepository.getAll();
        List<ProfileDO> profiles = list.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfileDO.class)).collect(Collectors.toList());

        return profiles;
    }

    public List<ProfileDO> getOneByPersonId(Long personId) {
        return profileRepository.getOneByPersonId(personId);
    }

    public ProfileDO getOneById(Long id) {
        return profileRepository.getOneById(id);
    }
}
