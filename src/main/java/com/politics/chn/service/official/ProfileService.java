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
        ProfilePO profile = BeanUtil.toBean(profileDO, ProfilePO.class);
        return profileRepository.addOne(profile);
    }

    public boolean addMany(List<ProfileDO> profileDOS) {
        if (profileDOS == null || profileDOS.isEmpty()) {
            return true;
        }

        List<ProfilePO> profiles = profileDOS.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfilePO.class)).collect(Collectors.toList());
        return profileRepository.addMany(profiles);
    }

    public boolean deleteOne(long id) {
        return profileRepository.deleteOne(id) ;
    }

    public boolean deleteOneByPersonId(long id) {
        return profileRepository.deleteOneByPersonId(id);
    }

    public boolean updateOne(ProfilePO profilePO) {
        return profileRepository.updateOne(profilePO);
    }

    public boolean updateMany(List<ProfileDO> profileDOS) {
        if (profileDOS == null || profileDOS.isEmpty()) {
            return true;
        }
        List<ProfilePO> profiles = profileDOS.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfilePO.class)).collect(Collectors.toList());
        return profileRepository.updateMany(profiles);
    }

    public List<ProfileDO> getAll() {
        List<ProfilePO> list = profileRepository.getAll();
        List<ProfileDO> profiles = list.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfileDO.class)).collect(Collectors.toList());

        return profiles;
    }

    public List<ProfileDO> getOneByPersonId(Long personId) {
        List<ProfilePO> list = profileRepository.getOneByPersonId(personId);
        List<ProfileDO> profiles = list.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfileDO.class)).collect(Collectors.toList());

        return profiles;
    }

    public ProfileDO getOneById(Long id) {
        ProfilePO profilePO = profileRepository.getOneById(id);

        ProfileDO profile = BeanUtil.toBean(profilePO, ProfileDO.class);
        return profile;
    }
}
