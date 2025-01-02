package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor
public class PostControllerJpaV4 {
    private final PostServiceJpaV4 postServiceJpaV4;

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@RequestBody PostCreateRequestDto requestDto){
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
