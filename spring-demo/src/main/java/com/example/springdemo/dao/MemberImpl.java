package com.example.springdemo.dao;

import com.example.springdemo.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberImpl implements ServiceDao<MemberDTO> {
    private final MemberRepository memberRepository;

    public MemberImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<MemberDTO> findById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public MemberDTO save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    @Override
    public MemberDTO update(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    @Override
    public void deleteById(String id) {
        memberRepository.deleteById(id);
    }
}
