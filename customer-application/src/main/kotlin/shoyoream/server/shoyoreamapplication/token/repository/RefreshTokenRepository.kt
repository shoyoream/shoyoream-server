package shoyoream.server.shoyoreamapplication.token.repository

import org.springframework.data.repository.CrudRepository
import shoyoream.server.shoyoreamapplication.token.entity.RefreshToken

interface RefreshTokenRepository : CrudRepository<RefreshToken, Long>
