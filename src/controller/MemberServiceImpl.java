package controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Member;
import model.MemberDAO;

public class MemberServiceImpl implements MemberService {
	
	private ArrayList<Member> memberList; // ȸ�� ���� ���̺� ���εǴ� ��ü
	private Member memberDTO; // ȸ�� ���� ���ڵ忡 ���εǴ� ��ü
	private MemberDAO memberDAO; // ȸ�� ���� ó���� ���� ���� �Ǵ� �����ͺ��̽��� �����ϴ� ��ü
	
	public MemberServiceImpl() {
		this(new File("member.txt"));		
	}
	public MemberServiceImpl(File file) {
		memberDAO = new MemberDAO(file);
	}
	
	@Override
	public Member read(Member member) {
		return memberDAO.selectMember(member);
	}

	@Override
	public ArrayList<Member> readList() {
		return memberDAO.selectAll();
	}

	@Override
	public int create(Member member) {
		if(memberDAO.insert(member) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public int update(Member member) {
		if(memberDAO.update(member) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public int delete(Member member) {
		if(memberDAO.delete(member) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public int findByUid(Member member) {
		return memberDAO.searchByID(member);
	}

}
