package com.example.myapp;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@PostMapping("/login/id")
	public boolean id (HttpServletRequest request) {
		// 요청을 보낸 클라이언트의 IP주소를 반환합니다.
		String tempId = "user";
		String tempPw = "user";
		if (tempId.equals(request.getParameter("id")) &&
			tempPw.equals(request.getParameter("pw"))) {
			return true;
		}
		System.out.println("로그인");
		return false;
	}
	@PostMapping("/login/redux")
	public Map<String, String> chkchk (HttpServletRequest request) {
		// 요청을 보낸 클라이언트의 IP주소를 반환합니다.
		Map<String, String> map = new TreeMap<>();
		String tempId = "user";
		String tempPw = "user";
		if (tempId.equals(request.getParameter("id")) &&
			tempPw.equals(request.getParameter("pw"))) {
			map.put("id", "user");
			map.put("nickname", "박감자");
			return map;
		}
		System.out.println("리덕스 로그인");
		map.put("id", "");
		map.put("nickname", "");
		return map;
	}
	
	@PostMapping("/adList")
	public Map<String, String> adList () {
		Map<String, String> map = new TreeMap<>();
		System.out.println("광고");
		for( int i = 0; i < 4; i++ ) {
			map.put("ad"+i, "/adFolder/ad"+i+".png");
		}
		
		return map;
	}
	
	@PostMapping("/main/info/all")
	public Map<String, String> infoAll () {
		Map<String, String> map = new TreeMap<>();
		
		for (int i = 0; i < 4; i++) {
			map.put("react"+i, "react");
		}
		for (int i = 0; i < 3; i++) {
			map.put("spring"+i, "spring");
		}
		map.put("java0", "java");
		System.out.println("메인페이지 정보 올 불러오기");
		return map;
	}
	
	@PostMapping("/main/info/seleted")
	public Map<String, String> infoSelected (HttpServletRequest request) {
		Map<String, String> map = new TreeMap<>();
		String[] result = request.getParameter("btnIdx").split(",");
		
		for (int i = 0; i < result.length-1; i++) {
			if (result[i].equals("react") && 
				result[i+1].equals("true")) {
				map.put("react0", "react");
				map.put("react1", "react");
				map.put("react2", "react");
				map.put("react3", "react");
			} else if (result[i].equals("spring") && 
					   result[i+1].equals("true")) {
				map.put("spring0", "spring");
				map.put("spring1", "spring");
				map.put("spring2", "spring");
			} else if (result[i].equals("java") && 
					   result[i+1].equals("true")) {
				map.put("java0", "java");
			}
		}
		
		System.out.println("request : 정보 단편 불러오기");
		
		return map;
	}
	
	
}
