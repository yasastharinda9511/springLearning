package com.springLearning.springLearning.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EnrollRequestDTO{
    private List<String> courseIds;
}
