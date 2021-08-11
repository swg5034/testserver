package com.test.testserver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.test.dto.MemberDto;
import com.test.service.MemberServiceImpl;

@SessionAttributes("member")
@Controller
public class HomeController {
	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "loginPage";
	}
	
	@RequestMapping(value = "/loginPage")
	public String login() {
		return "loginPage";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
   
        MemberDto m = new MemberDto();
        m.setId(id);
        m = service.select_user(m);
        if(m.getId()!=null) {
        	
        	if(m.getPw().equals(pw)) {
        		model.addAttribute("dto", m);
        		HttpSession session = request.getSession();
        		session.setAttribute("loginId", m.getId());
        		if(m.getId().equals("admin")) {
        			return "admin";
        		}else {
        			
        			return "main";
        		}
        	}
        }
        	model.addAttribute("msg", "<script>alert('아이디/비밀번호를 다시 확인하세요');</script>");
        	return "loginPage";
        
    }
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		if(!status.isComplete()) {
			status.setComplete();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/joinPage")
	public String joinPage() {
		return "joinPage";
	}
	
	@RequestMapping(value = "/join")
	public String join(String id,String pw,String name,Model model) throws Exception {
		MemberDto m = new MemberDto();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		service.insert(m);
		return "loginPage";
	}
	@RequestMapping(value = "/point10")
	public String point10(HttpServletRequest request,HttpSession session,Model model) throws Exception {
		MemberDto m = new MemberDto();
		m.setId((String)session.getAttribute("loginId"));
		m = service.select_user(m);
		int point = Integer.parseInt(request.getParameter("point"));
		if(point > 100000) {
			MemberDto m2 = new MemberDto();
			m2.setId(m.getId());
			m2.setName(m.getName());
			m2.setPw(m.getPw());
			m2.setPoint(point-100000);
			service.update(m2);
			model.addAttribute("dto", m2);
			request.setAttribute("point", "<script>alert('컨텐츠(intro)를 구입하였습니다');</script>");
			return "main";
		}else {
			
			model.addAttribute("dto", m);
			request.setAttribute("point", "<script>alert('포인트가부족합니다 광고를 클릭하세요');</script>");
			return "main";
		}
	}
	@RequestMapping(value = "/point30")
	public String point30(HttpServletRequest request,HttpSession session,Model model) throws Exception {
		MemberDto m = new MemberDto();
		m.setId((String)session.getAttribute("loginId"));
		m = service.select_user(m);
		int point = Integer.parseInt(request.getParameter("point"));
		if(point > 300000) {
			MemberDto m2 = new MemberDto();
			m2.setId(m.getId());
			m2.setName(m.getName());
			m2.setPw(m.getPw());
			m2.setPoint(point-300000);
			service.update(m2);
			model.addAttribute("dto", m2);
			request.setAttribute("point", "<script>alert('컨텐츠(intro)를 구입하였습니다');</script>");
			return "main";
		}else {
			
			model.addAttribute("dto", m);
			request.setAttribute("point", "<script>alert('포인트가부족합니다 광고를 클릭하세요');</script>");
			return "main";
		}
	}
	@RequestMapping(value = "/point50")
	public String point50(HttpServletRequest request,HttpSession session,Model model) throws Exception {
		MemberDto m = new MemberDto();
		m.setId((String)session.getAttribute("loginId"));
		m = service.select_user(m);
		int point = Integer.parseInt(request.getParameter("point"));
		if(point > 500000) {
			MemberDto m2 = new MemberDto();
			m2.setId(m.getId());
			m2.setName(m.getName());
			m2.setPw(m.getPw());
			m2.setPoint(point-500000);
			service.update(m2);
			model.addAttribute("dto", m2);
			request.setAttribute("point", "<script>alert('컨텐츠(intro)를 구입하였습니다');</script>");
			return "main";
		}else {
			
			model.addAttribute("dto", m);
			request.setAttribute("point", "<script>alert('포인트가부족합니다 광고를 클릭하세요');</script>");
			return "main";
		}
	}
	@RequestMapping(value = "/point1000")
	public void addpoint(HttpServletRequest request,HttpSession session,Model model,HttpServletResponse res) throws Exception {
		MemberDto m = new MemberDto();
		m.setId((String)session.getAttribute("loginId"));
		m = service.select_user(m);
		m.setPoint(m.getPoint()+1000);
		service.update(m);
		res.sendRedirect("http://www.koreaisacademy.com/");
		
	}
	@RequestMapping(value = "/start")
	public String homeStart() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("스케줄러가 시작됨.");
		return "home";
	}
	
	@RequestMapping(value = "/stop")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String homeEnd() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("스케줄러가 종료됨.");
		return "home";
	}
}
