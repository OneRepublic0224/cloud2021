package com.zsh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhangsihang
 * @Time 2020/10/29 13:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long id;
    private String serial;
}
