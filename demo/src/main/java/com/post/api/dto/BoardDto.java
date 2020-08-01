package com.post.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private int categoryId;
    private Date modifyDate;
}