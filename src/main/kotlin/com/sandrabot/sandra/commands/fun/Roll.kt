/*
 * Copyright 2017-2022 Avery Carroll and Logan Devecka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sandrabot.sandra.commands.`fun`

import com.sandrabot.sandra.constants.Unicode
import com.sandrabot.sandra.entities.Command
import com.sandrabot.sandra.events.CommandEvent

@Suppress("unused")
class Roll : Command(name = "roll", arguments = "[sides:integer:4,6,8,10,12,20] [max:integer]") {

    override suspend fun execute(event: CommandEvent) {

        val bound = event.arguments.integer("sides") ?: event.arguments.integer("max") ?: 20
        event.replyEmote(event.translate("reply", (1..bound).random()), Unicode.GAME_DIE).queue()

    }

}
