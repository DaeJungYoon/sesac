package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.*;
import com.example.demo.myjpasitev4.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor
public class PostControllerJpaV4 {
    private final PostServiceJpaV4 postServiceJpaV4;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("resoure not found", "NOT_FOUND"));
    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<ApiResponse<Void>> handleNotFound(NoHandlerFoundException ex) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(ApiResponse.error("요청한 리소스를 찾을 수 없습니다dd: " + ex.getRequestURL(),
//                        "NOT_FOUND"));
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException .class)
//    public ResponseEntity<ApiResponse<Void>> handleMethodNotFound(HttpRequestMethodNotSupportedException ex) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(ApiResponse.error("method not allowed", "METHOD_NOT_ALLOWED"));
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto){
        return ResponseEntity
                .status(HttpStatus.CREATED) // status가 있으면 이것을 보여주는 것이 좋긴함
                .body(
                        ApiResponse.ok(
                                "게시글을 정상적을 작성되었습니다.",
                                "CREATE",
                                postServiceJpaV4.createPost(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts(){
        List<PostListResponseDto> data = postServiceJpaV4.readPosts();
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(data); //message, code, data를 넣기 위해
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> readPostById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.ok(postServiceJpaV4.readPostById(id)));
    }
    // PUT id 제목 / 내용 dto data
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){

        return ResponseEntity.ok(ApiResponse.ok(postServiceJpaV4.updatePost(id, requestDto)));

    }

//    @DeleteMapping("/{id}")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> deletePost(@PathVariable Long id){
//        postServiceJpaV4.deletePost(id);
//        return ResponseEntity.noContent().build();
//    }
    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id){
        postServiceJpaV4.deletePost(id);
        return ResponseEntity.ok(
                ApiResponse
                        .ok(
                                "게시글 삭제되었습니다",
                                "DELETE",
                                null
                        )
        );
    }

}
