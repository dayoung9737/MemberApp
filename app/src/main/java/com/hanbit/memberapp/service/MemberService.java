package com.hanbit.memberapp.service;

import com.hanbit.memberapp.domain.MemberBean;

import java.util.List;

/**
 * Created by hb2004 on 2016-12-17.
 */

public interface MemberService {
    //public void detail
    public MemberBean detail(String id);
    public List<MemberBean> find(String keyword);//List는 리턴값이 여러개라도 에러가 나지 않음
    public void join(MemberBean param);
    public List<MemberBean> list();
    public boolean login(MemberBean param);
    public void update(MemberBean param);
    public void delete(String id);
    public int count();



}
