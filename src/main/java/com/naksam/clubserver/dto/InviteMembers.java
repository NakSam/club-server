package com.naksam.clubserver.dto;

import lombok.Data;

import java.util.List;

@Data
public class InviteMembers {
    private Long clubId;

    private List<String> emails;
}
