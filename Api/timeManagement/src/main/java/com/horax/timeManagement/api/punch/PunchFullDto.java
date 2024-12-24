package com.horax.timeManagement.api.punch;

import java.security.Timestamp;

public class PunchFullDto
{
    private final Timestamp timeStamp;

    public PunchFullDto(Timestamp timestamp) {
        this.timeStamp = timestamp;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

}
