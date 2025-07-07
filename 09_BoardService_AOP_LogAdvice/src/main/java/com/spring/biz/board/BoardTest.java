package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.board.impl.BoardServiceImpl;

public class BoardTest {

    public static void main(String[] args) {
        BoardDAO dao = new BoardDAO();
        BoardVO vo = new BoardVO();
        BoardService boardService = new BoardServiceImpl(dao);

        
        
        // ▶ 게시글 입력 테스트
        System.out.println("\n ▶ 게시글 입력 테스트");
        vo.setTitle("제목 테스트7");
        vo.setWriter("작성자 테스트7");
        vo.setContent("내용 테스트7");

        dao.insertBoard(vo);

        
        
        // ▶ 게시글 전체 조회 테스트
        System.out.println("\n ▶ 게시글 조회(전체) 테스트");
        List<BoardVO> boardList = dao.getBoardList();
        for (BoardVO board : boardList) {
            System.out.println(" - 시퀸스 : " + board.getSeq() + " / " +
                               board.getTitle() + " / " +
                               board.getWriter() + " / " +
                               board.getRegdate() + " / 조회수: " + board.getCnt());
        }

        
        
        // ▶ 게시글 단일 조회 테스트
        System.out.println("\n ▶ 게시글 조회(단일) 테스트");
        vo.setSeq(5);
        BoardVO result = dao.getBoard(vo);
        if (result != null) {
            System.out.println(" - " + result.getTitle() + " / " + result.getWriter());
        } else {
            System.out.println(" - 게시글 존재하지 않음");
        }

        
        
        // ▶ 게시글 수정 테스트
        System.out.println("\n ▶ 게시글 수정 테스트");
        vo.setSeq(3); // 실제 존재하는 SEQ로 테스트
        vo.setTitle("3을 수정해요");
        vo.setContent("3을 수정해요");

        dao.updateBoard(vo);
        BoardVO updated = dao.getBoard(vo);
        System.out.println(" - " + updated.getTitle() + " / " + updated.getContent());

        
        
        // ▶ 게시글 삭제 테스트
        System.out.println("\n ▶ 게시글 삭제 테스트");
        vo.setSeq(2);
        dao.deleteBoard(vo);
        BoardVO deleted = dao.getBoard(vo);
        if (deleted == null) {
            System.out.println(" - 삭제 성공");
        } else {
            System.out.println(" - 삭제 실패");
        }
    }
}
