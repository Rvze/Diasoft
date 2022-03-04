package com.example.kafka;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private Long id;

    private String message;

    private String jwt;
}