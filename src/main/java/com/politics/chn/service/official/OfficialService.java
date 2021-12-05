package com.politics.chn.service.official;

import com.politics.chn.domain.official.entity.Official;
import com.politics.chn.domain.official.repository.OfficialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@Repository
public class OfficialService {
    private OfficialRepository officialRepository;

    @Autowired
    private void setOfficialRepository(OfficialRepository officialRepository) {
        this.officialRepository = officialRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean addOfficial(Official official) {
        return officialRepository.save(official);
    }

    public Boolean deleteOfficial(long id) {
        return officialRepository.remove(id);
    }

    public Boolean updateOfficial(Official official) {
        return officialRepository.save(official);
    }

    public List<Official> getAllOfficial() {
        return officialRepository.queryPerson(null);
    }

    public Official getOfficialById(Long id) {
        return officialRepository.find(id);
    }

}
