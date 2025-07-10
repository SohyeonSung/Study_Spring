package com.spring.biz.view.board;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateBoardController {

    @RequestMapping("/updateBoard.do")
    public ModelAndView updateBoard(
            @RequestParam("seq") int seq,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            BoardDAO boardDAO,
            ModelAndView mav) {
        
        System.out.println(">> 게시글 수정 처리");

        // 1. 전달받은 데이터를 VO에 설정
        BoardVO vo = new BoardVO();
        vo.setSeq(seq);
        vo.setTitle(title);
        vo.setContent(content);

        // 2. DB 연동작업 (UPDATE)
        boardDAO.updateBoard(vo);

        // 3. 목록 페이지로 리다이렉트
        mav.setViewName("redirect:getBoardList.do");

        return mav;
    }
}
