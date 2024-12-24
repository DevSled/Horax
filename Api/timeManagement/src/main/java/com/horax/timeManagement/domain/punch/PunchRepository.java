package com.horax.timeManagement.domain.punch;

import com.horax.timeManagement.domain.BasicRepository;
import com.horax.timeManagement.domain.DeleteRepository;
import com.horax.timeManagement.domain.ReadRepository;
import com.horax.timeManagement.domain.UpdateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PunchRepository extends BasicRepository<String, Punch>, DeleteRepository<String, Punch>, UpdateRepository<String, Punch>, ReadRepository<String, Punch> {

}
