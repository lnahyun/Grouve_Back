package agora.webproject.controller;

import agora.webproject.dto.MeetingDTO;
import agora.webproject.service.MeetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
@Slf4j
public class MeetingController {

    private final MeetingService meetingService;

    @GetMapping("/create")
    public String showMeetingRegisterPage(Model model) {
        model.addAttribute("meetingDTO", new MeetingDTO());
        return "createMeetings";
    }

    @PostMapping("/create")
    public String registerMeeting(@ModelAttribute MeetingDTO meetingDTO, MultipartFile image, Model model) {
        try {
            meetingService.saveMeeting(meetingDTO, image);
            model.addAttribute("message", "모임이 성공적으로 등록되었습니다.");
            return "createMeetings";
        } catch (Exception e) {
            log.error("모임 등록 실패", e);
            model.addAttribute("message", "모임 등록에 실패했습니다.");
            return "createMeetings";
        }
    }
}