/*
 * Copyright 2017-2021 Avery Carroll and Logan Devecka
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
import com.sandrabot.sandra.utils.splitSpaces
import net.dv8tion.jda.api.entities.Message

@Suppress("unused")
class Clap : Command(name = "clap", arguments = "[text]") {

    override suspend fun execute(event: CommandEvent) {

        val text = event.arguments.text() ?: Unicode.CLAPPING_HANDS
        val clapText = text.splitSpaces().joinToString(" ${Unicode.CLAPPING_HANDS} ").trim()

        if (clapText.length > Message.MAX_CONTENT_LENGTH) {
            event.replyError(event.translate("commands.clap.max_length"))
        } else event.message.reply(clapText).allowedMentions(emptyList()).queue()

    }

}
