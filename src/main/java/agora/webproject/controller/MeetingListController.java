package agora.webproject.controller;

import agora.webproject.dto.MeetingDTO;
import agora.webproject.service.MeetingListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
@Slf4j
public class MeetingListController {

    private final MeetingListService meetingListService;

    @GetMapping("/list")
    public List<MeetingDTO> getAllMeetings() {
        try {
            return meetingListService.getAllMeetings();
        } catch (Exception e) {
            log.error("모임 목록 조회 실패", e);
            return List.of(); // 빈 리스트 반환
        }
    }
}
