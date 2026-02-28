/*
 * Copyright 2020 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mikepenz.iconics.typeface.library.fontawesome

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.LinkedList

@Suppress("EnumEntryName")
object FontAwesomeRegular : ITypeface {

    override val fontRes: Int
        get() = R.font.fontawesome_regular_font_v5_13_3

    override val characters: Map<String, Char> by lazy {
        Icon.values().associate { it.name to it.character }
    }

    override val mappingPrefix: String
        get() = "far"

    override val fontName: String
        get() = "FontAwesome Regular"

    override val version: String
        get() = "5.13.3.0"

    override val iconCount: Int
        get() = characters.size

    override val icons: List<String>
        get() = characters.keys.toCollection(LinkedList())

    override val author: String
        get() = "FontAwesome"

    override val url: String
        get() = "https://fontawesome.com/"

    override val description: String
        get() = "The internet's most popular icon toolkit has been redesigned and built from scratch. On top of this, features like icon font ligatures, an SVG framework, official NPM packages for popular frontend libraries like React, and access to a new CDN."

    override val license: String
        get() = "Font Awesome Free License"

    override val licenseUrl: String
        get() = "https://github.com/FortAwesome/Font-Awesome/blob/master/LICENSE.txt"

    override fun getIcon(key: String): IIcon = Icon.valueOf(key)

    enum class Icon constructor(override val character: Char) : IIcon {
        far_address_book('\ue900'),
        far_address_card('\ue901'),
        far_angry('\ue902'),
        far_arrow_alt_circle_down('\ue903'),
        far_arrow_alt_circle_left('\ue904'),
        far_arrow_alt_circle_right('\ue905'),
        far_arrow_alt_circle_up('\ue906'),
        far_bell('\ue908'),
        far_bell_slash('\ue907'),
        far_bookmark('\ue909'),
        far_building('\ue90a'),
        far_calendar('\ue910'),
        far_calendar_alt('\ue90b'),
        far_calendar_check('\ue90c'),
        far_calendar_minus('\ue90d'),
        far_calendar_plus('\ue90e'),
        far_calendar_times('\ue90f'),
        far_caret_square_down('\ue911'),
        far_caret_square_left('\ue912'),
        far_caret_square_right('\ue913'),
        far_caret_square_up('\ue914'),
        far_chart_bar('\ue915'),
        far_check_circle('\ue916'),
        far_check_square('\ue917'),
        far_circle('\ue918'),
        far_clipboard('\ue919'),
        far_clock('\ue91a'),
        far_clone('\ue91b'),
        far_closed_captioning('\ue91c'),
        far_comment('\ue91f'),
        far_comment_alt('\ue91d'),
        far_comment_dots('\ue91e'),
        far_comments('\ue920'),
        far_compass('\ue921'),
        far_copy('\ue922'),
        far_copyright('\ue923'),
        far_credit_card('\ue924'),
        far_dizzy('\ue925'),
        far_dot_circle('\ue926'),
        far_edit('\ue927'),
        far_envelope('\ue929'),
        far_envelope_open('\ue928'),
        far_eye('\ue92b'),
        far_eye_slash('\ue92a'),
        far_file('\ue936'),
        far_file_alt('\ue92c'),
        far_file_archive('\ue92d'),
        far_file_audio('\ue92e'),
        far_file_code('\ue92f'),
        far_file_excel('\ue930'),
        far_file_image('\ue931'),
        far_file_pdf('\ue932'),
        far_file_powerpoint('\ue933'),
        far_file_video('\ue934'),
        far_file_word('\ue935'),
        far_flag('\ue937'),
        far_flushed('\ue938'),
        far_folder('\ue93a'),
        far_folder_open('\ue939'),
        far_frown('\ue93c'),
        far_frown_open('\ue93b'),
        far_futbol('\ue93d'),
        far_gem('\ue93e'),
        far_grimace('\ue93f'),
        far_grin('\ue94c'),
        far_grin_alt('\ue940'),
        far_grin_beam('\ue942'),
        far_grin_beam_sweat('\ue941'),
        far_grin_hearts('\ue943'),
        far_grin_squint('\ue945'),
        far_grin_squint_tears('\ue944'),
        far_grin_stars('\ue946'),
        far_grin_tears('\ue947'),
        far_grin_tongue('\ue94a'),
        far_grin_tongue_squint('\ue948'),
        far_grin_tongue_wink('\ue949'),
        far_grin_wink('\ue94b'),
        far_hand_lizard('\ue94d'),
        far_hand_paper('\ue94e'),
        far_hand_peace('\ue94f'),
        far_hand_point_down('\ue950'),
        far_hand_point_left('\ue951'),
        far_hand_point_right('\ue952'),
        far_hand_point_up('\ue953'),
        far_hand_pointer('\ue954'),
        far_hand_rock('\ue955'),
        far_hand_scissors('\ue956'),
        far_hand_spock('\ue957'),
        far_handshake('\ue958'),
        far_hdd('\ue959'),
        far_heart('\ue95a'),
        far_hospital('\ue95b'),
        far_hourglass('\ue95c'),
        far_id_badge('\ue95d'),
        far_id_card('\ue95e'),
        far_image('\ue95f'),
        far_images('\ue960'),
        far_keyboard('\ue961'),
        far_kiss('\ue964'),
        far_kiss_beam('\ue962'),
        far_kiss_wink_heart('\ue963'),
        far_laugh('\ue968'),
        far_laugh_beam('\ue965'),
        far_laugh_squint('\ue966'),
        far_laugh_wink('\ue967'),
        far_lemon('\ue969'),
        far_life_ring('\ue96a'),
        far_lightbulb('\ue96b'),
        far_list_alt('\ue96c'),
        far_map('\ue96d'),
        far_meh('\ue970'),
        far_meh_blank('\ue96e'),
        far_meh_rolling_eyes('\ue96f'),
        far_minus_square('\ue971'),
        far_money_bill_alt('\ue972'),
        far_moon('\ue973'),
        far_newspaper('\ue974'),
        far_object_group('\ue975'),
        far_object_ungroup('\ue976'),
        far_paper_plane('\ue977'),
        far_pause_circle('\ue978'),
        far_play_circle('\ue979'),
        far_plus_square('\ue97a'),
        far_question_circle('\ue97b'),
        far_registered('\ue97c'),
        far_sad_cry('\ue97d'),
        far_sad_tear('\ue97e'),
        far_save('\ue97f'),
        far_share_square('\ue980'),
        far_smile('\ue983'),
        far_smile_beam('\ue981'),
        far_smile_wink('\ue982'),
        far_snowflake('\ue984'),
        far_square('\ue985'),
        far_star('\ue987'),
        far_star_half('\ue986'),
        far_sticky_note('\ue988'),
        far_stop_circle('\ue989'),
        far_sun('\ue98a'),
        far_surprise('\ue98b'),
        far_thumbs_down('\ue98c'),
        far_thumbs_up('\ue98d'),
        far_times_circle('\ue98e'),
        far_tired('\ue98f'),
        far_trash_alt('\ue990'),
        far_user('\ue992'),
        far_user_circle('\ue991'),
        far_window_close('\ue993'),
        far_window_maximize('\ue994'),
        far_window_minimize('\ue995'),
        far_window_restore('\ue996');

        override val typeface: ITypeface by lazy { FontAwesomeRegular }
    }
}