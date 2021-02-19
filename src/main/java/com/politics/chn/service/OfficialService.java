package com.politics.chn.service;

import com.politics.chn.repo.repository.OfficialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
