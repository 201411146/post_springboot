package com.post.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private int categoryId;
    private Date createDate;
    private Date modifyDate;
}