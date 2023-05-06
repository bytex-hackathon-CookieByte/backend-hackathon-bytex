package ro.fiipractic.hackathon.jobyfier.service;

import org.springframework.stereotype.Service;
import ro.fiipractic.hackathon.jobyfier.dto.request.ChallengeRequestDto;
import ro.fiipractic.hackathon.jobyfier.model.Challenge;
import ro.fiipractic.hackathon.jobyfier.repository.ChallengeRepository;

import java.time.Instant;

@Service
public class ChallengeService {

    final private ChallengeRepository challengeRepository;


    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }


    public Challenge convertDtoToChallenge(ChallengeRequestDto challengeRequestDto) {
        Instant startTime = Instant.parse(challengeRequestDto.getStartTime());

        return new Challenge(challengeRequestDto.getTitle(),
                challengeRequestDto.getDescription(),
                challengeRequestDto.getPrice(),
                challengeRequestDto.getAdPrice(),
                startTime.toEpochMilli(),
                null
                );
    }
}
