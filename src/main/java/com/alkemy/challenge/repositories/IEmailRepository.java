package com.alkemy.challenge.repositories;

import com.alkemy.challenge.models.EMail;

public interface IEmailRepository {

    public void sendMail(EMail mail);

}
