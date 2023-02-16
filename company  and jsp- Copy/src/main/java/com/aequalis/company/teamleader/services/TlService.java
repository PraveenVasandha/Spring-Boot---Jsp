package com.aequalis.company.teamleader.services;

import com.aequalis.company.teamleader.dto.TlDto;

import java.util.List;

public interface TlService {
    TlDto createTeamLeader(TlDto tlDto);

    List<TlDto> getAllTeamLeaderName();

    TlDto updateTeamleader(TlDto tlDto);

    boolean deleteSingleId(Integer id);

    TlDto getTeamLeader(Integer id);
}
