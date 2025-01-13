package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok("게시글이 성공적으로 작성되었습니다","CREATED",
                                postService.createPost(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(postService.readPosts());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDto>> readPostById(@PathVariable Long id) {
        ApiResponse<PostWithCommentResponseDto> response = ApiResponse.ok(postService.readPostById(id));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/v2/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDtoV2>> readPostByIdV2(@PathVariable Long id) {
        ApiResponse<PostWithCommentResponseDtoV2> response = ApiResponse.ok(postService.readPostByIdV2(id));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok("게시글이 성공적으로 수정되었습니다", "UPDATED", postService.updatePost(id, requestDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        ApiResponse<Void> response = ApiResponse.ok("게시글이 성공적으로 삭제되었습니다", "DELETED", null);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/comment-count")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCount(){
        return  ResponseEntity.ok(
                    ApiResponse.ok(
                        postService.readPostsWithCommentCount()
                )
        );
    }

    @GetMapping("/comment-count-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCountDto(){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithCommentCountDto()
        ));
    }

    // post와 tag를 가지고 연결시켜주기

    @PostMapping("/{id}/tags")
    public void addTagToPost(@PathVariable Long id,
                             @Valid @RequestBody TagRequestDto tagRequestDto
    ) {
      postService.addTagToPost(id, tagRequestDto);
    }

    @PostMapping("/{id}/detail")
    public PostWithCommentAndTagResponseDto readPostsByIdWithCommentAndTag(@PathVariable Long id){
        return postService.readPostsByIdWithCommentAndTag(id);
    }

    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostsByIdWithCommentAndTagV2(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.ok(
          postService.readPostsByIdWithCommentAndTagV2(id)
        ));


    }

    @GetMapping("/tags")
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPostsByTag(@RequestParam String tagName){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsByTag(tagName)
        ));
    }

    @GetMapping("/tags/all")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2>>> readPostsWithCommentByTag(@RequestParam String tagName){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithCommentByTag(tagName)
        ));
    }

    @GetMapping("/pages")
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPostsWithPage(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithPage(pageable)
        )
        );

    }

}





