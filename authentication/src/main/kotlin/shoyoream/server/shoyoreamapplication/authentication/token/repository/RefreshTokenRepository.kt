package shoyoream.server.shoyoreamapplication.authentication.token.repository

import org.springframework.data.repository.CrudRepository
import shoyoream.server.shoyoreamapplication.authentication.token.entity.RefreshToken

interface RefreshTokenRepository : CrudRepository<RefreshToken, Long>
