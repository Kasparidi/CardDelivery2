package ru.netology.web.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InfoClient {
    public final String city;
    public final String name;
    public final String phoneNumber;
}
