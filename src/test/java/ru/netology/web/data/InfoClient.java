package ru.netology.web.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoClient {
    public final String city;
    public final String name;
    public final String phoneNumber;

}
