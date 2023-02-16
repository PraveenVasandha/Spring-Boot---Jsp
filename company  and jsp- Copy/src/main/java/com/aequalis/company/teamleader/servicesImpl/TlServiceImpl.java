package com.aequalis.company.teamleader.servicesImpl;

import com.aequalis.company.teamleader.dao.TlDao;
import com.aequalis.company.teamleader.dto.TlDto;
import com.aequalis.company.teamleader.mapper.TlMapper;
import com.aequalis.company.teamleader.repository.TlRepository;
import com.aequalis.company.teamleader.services.TlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TlServiceImpl implements TlService {

    Logger logger= LoggerFactory.getLogger(TlServiceImpl.class);

    @Autowired
    private TlRepository tlRepository;

    @Override
    @Transactional
    public TlDto createTeamLeader(TlDto tlDto) {
       // logger.info("Create Team Leader Servies Method");
        try{
           // TlDto tlDto2=new TlDto();
           // List<String> list= Arrays.asList("Aequalis","India");
            TlDao tlDao= TlMapper.TL_MAPPER.tlDao(tlDto);
            TlDao tlDao1=tlRepository.saveAndFlush(tlDao);
            TlDto tlDto1=TlMapper.TL_MAPPER.tlDto(tlDao1);
            return tlDto1;
        }
        catch (Exception e){
            logger.error("Not Send Null Column",e);
            return tlDto;
        }
        finally {
           // logger.info("Exit Create Team Leader Services Method");
        }
    }

    @Override
    public List<TlDto> getAllTeamLeaderName() {
       // logger.info("Enter Service get all name list");
        List<TlDto> tlDto = new ArrayList<>();
        try{
             return ((List<TlDao>) tlRepository
                     .findAll())
                     .stream()
                     .map(this::convertToTlDto)
                     .collect(Collectors.toList());
        }
        catch (Exception e){
            logger.error("not get single Id",e);
            return tlDto;
        }
        finally {
            //logger.info("Exit get all service method");
        }

    }
    private TlDto convertToTlDto(TlDao tlDao){
        TlDto tlDto = new TlDto();
        tlDto.setId(tlDao.getTeamLeadeId());
        tlDto.setName(tlDao.getTeamLeaderName());
        tlDto.setEmailId(tlDao.getEmailId());
        tlDto.setAge(tlDao.getAge());
        tlDto.setOfficeName(tlDao.getOfficeName());
        tlDto.setCountry(tlDao.getCountry());
        tlDto.setDistrict(tlDao.getDistrict());
        tlDto.setVillage(tlDao.getVillage());
        tlDto.setPincode(tlDao.getPincode());

        return tlDto;
    }
    @Override
    public TlDto updateTeamleader(TlDto tlDto) {
        logger.info("Update Service method");
        try{
            TlDao tlDao=TlMapper.TL_MAPPER.tlDao(tlDto);
            TlDao tlDao1=tlRepository.save(tlDao);
            TlDto tlDto1=TlMapper.TL_MAPPER.tlDto(tlDao1);
            return tlDto;
        }
        catch (Exception e){
            logger.error("Not send null values");
            return tlDto;
        }
        finally {
            logger.info("Exit services update method");
        }
    }

    @Override
    public boolean deleteSingleId(Integer id) {
      //  logger.info("Delete method Enter service layer");
       // TlDto tlDto = new TlDto();
        try{
            TlDao tlDao = new TlDao();
           if (id !=null){
               tlDao.setTeamLeadeId(id);
               tlRepository.delete(tlDao);
           }

            return true;

        }
        catch (Exception e){
            logger.error("Not send String values",e);
            return false;
        }

    }

    @Override
    public TlDto getTeamLeader(Integer id) {
        TlDao tlDao=tlRepository.findByTeamLeadeId(id);
        TlDto tlDto = new TlDto();
        tlDto.setId(tlDao.getTeamLeadeId());
        tlDto.setState(tlDao.getState());
        tlDto.setPincode(tlDao.getPincode());
        tlDto.setDistrict(tlDao.getDistrict());
        tlDto.setVillage(tlDao.getVillage());
        tlDto.setName(tlDao.getTeamLeaderName());
        tlDto.setAge(tlDao.getAge());
        tlDto.setOfficeName(tlDao.getOfficeName());
        tlDto.setEmailId(tlDao.getEmailId());
        tlDto.setCountry(tlDao.getCountry());

        return tlDto;
    }
}
