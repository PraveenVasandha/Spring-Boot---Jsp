package com.aequalis.company.teamleader.controller;

import com.aequalis.company.teamleader.dto.TlDto;
import com.aequalis.company.teamleader.services.TlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TlResource {

    Logger logger= LoggerFactory.getLogger(TlResource.class);
    @Autowired
    TlService tlService;

    @GetMapping("/home")
    public String teamLeader(){
System.out.println("hello");


        return "home";
    }

    @GetMapping("/team-leader")
    public String teamLeader(Model model){
        System.out.println("hello");
        TlDto tlDto=new TlDto();
        model.addAttribute("tlDto",tlDto);

        return "team-leader";
    }
    @RequestMapping(value = "/team-leader",method = RequestMethod.POST)
    public String addTeamLeader(@ModelAttribute TlDto tlDto){
      //  logger.info("Created Team Leater");
        System.out.println("Praveen");
        try{
/*
            tlDto.setName(request.getAttribute("name").toString());
            tlDto.setEmailId(request.getAttribute("emailId").toString());
            tlDto.setAge(Integer.parseInt(request.getAttribute("age").toString()));
            tlDto.setOfficeName(request.getAttribute("officeName").toString());
            tlDto.setCountry(request.getAttribute("country").toString());
            tlDto.setState(request.getAttribute("state").toString());
            tlDto.setDistrict(request.getAttribute("district").toString());
            tlDto.setVillage(request.getAttribute("village").toString());
            tlDto.setPincode(Integer.parseInt(request.getAttribute("pincode").toString()));*/
            tlService.createTeamLeader(tlDto);
           return "redirect:/view-team-leader";

       }
       catch (Exception e){
           logger.error("Not send null values",e);
           return "team-leader";
       }
       finally {
          // logger.info("Exit Add Team Leader ");
       }
   }
   @GetMapping("/view-team-leader")
    public String getTeamLeader(Model model){
       // logger.info("Get all team leader name list");
       List<TlDto> tlDtoList = new ArrayList<>();
        try{
          tlDtoList = tlService.getAllTeamLeaderName();
            model.addAttribute("list",tlDtoList);
          return "view-team-leader";
        }catch (Exception e){
            logger.error("Not get single team leader name",e);
            return "view-team-leader";
        }
        finally {
            //logger.info("Exit  team leader name list");
        }
    }
    @GetMapping("/edit-team-leader")
    public String editTeamLeader(@RequestParam("id") Integer id,Model model){
        System.out.println("hello");

        TlDto tlDto = tlService.getTeamLeader(id);
        model.addAttribute("tlDto",tlDto);
        return "edit-team-leader";
    }

   @PostMapping("/edit-team-leader")
    public String updateName(@ModelAttribute TlDto tlDto){
        logger.info("Update team leader ");
        try{
            tlService.updateTeamleader(tlDto);
            return "redirect:/view-team-leader";
        }
        catch (Exception e){
            logger.error("Not send null values");
            return "edit-team-leader";
        }
        finally {
            logger.info("Update team leader exit");
        }
    }
    @GetMapping("/delete-team-leader")
    public String remove(@RequestParam("id") Integer id ){
          //  logger.info("Delete method in resource");
           // boolean boo;
            try{
              //  String teamId = requestg.getParameter("id");
                 tlService.deleteSingleId(id);
                return "redirect:/view-team-leader";
            }
            catch (Exception e){
                logger.error("Not sent String values",e);
                return "Plesa send id";
            }
            finally {
              //  logger.info("Exit delete method in resource");
            }
    }

}
