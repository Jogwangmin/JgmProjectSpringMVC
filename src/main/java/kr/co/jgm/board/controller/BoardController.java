package kr.co.jgm.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.jgm.board.domain.Board;
import kr.co.jgm.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping(value="board/insert.do", method=RequestMethod.GET)
	public String showInsertForm() {
		return "board/boardInsert";
	}
	
	@RequestMapping(value="/board/insert.do", method=RequestMethod.POST)
	public String InsertBoard(
			@ModelAttribute Board board
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request
			, Model model) {
		try {
			if(!uploadFile.getOriginalFilename().equals("")) {
				String fileName = uploadFile.getOriginalFilename();
				String root = request.getSession().getServletContext().getRealPath("resources");
				String saveFolder = root + "\\nuploadFiles";
				File folder = new File(saveFolder);
				if(!folder.exists()) {
					folder.mkdir();
				}
				String savePath = saveFolder + "\\" + fileName;
				File file = new File(savePath);
				uploadFile.transferTo(file);
				long fileLength = uploadFile.getSize();
				
				board.setBoardFileName(fileName);
				board.setBoardFilePath(savePath);
				board.setBoardFileLength(fileLength);
			}
			int result = service.insertBoard(board);
			if(result > 0) {
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "게시글 등록이 완료되지 않았습니다.");
				model.addAttribute("error", "게시글 등록 실패");
				model.addAttribute("url", "/board.insert.do");
				return "common/errorPage";
			}
			
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
		
	}
			
}
