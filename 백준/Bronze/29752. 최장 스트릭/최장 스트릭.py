def longest_streak(N, solved_per_day):
    max_streak = 0
    current_streak = 0

    for i in range(N):
        if solved_per_day[i] > 0:
            current_streak += 1
            max_streak = max(max_streak, current_streak)
        else:
            current_streak = 0

    return max_streak

# 입력 받기
N = int(input().strip())
solved_per_day = list(map(int, input().strip().split()))

# 가장 긴 연속된 풀이 기간 출력
print(longest_streak(N, solved_per_day))