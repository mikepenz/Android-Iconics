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
package com.mikepenz.iconics.typeface.library.octicons

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.LinkedList

@Suppress("EnumEntryName")
object Octicons : ITypeface {

    override val fontRes: Int
        get() = R.font.octicons_v11_1_0

    override val characters: Map<String, Char> by lazy {
        Icon.values().associate { it.name to it.character }
    }

    override val mappingPrefix: String
        get() = "oct"

    override val fontName: String
        get() = "Octicons"

    override val version: String
        get() = "11.1.0"

    override val iconCount: Int
        get() = characters.size

    override val icons: List<String>
        get() = characters.keys.toCollection(LinkedList())

    override val author: String
        get() = "GitHub"

    override val url: String
        get() = "https://github.com/primer/octicons"

    override val description: String
        get() = "GitHub's icon font https://github.com/primer/octicons"

    override val license: String
        get() = "MIT License"

    override val licenseUrl: String
        get() = "https://github.com/primer/octicons/blob/master/LICENSE"

    override fun getIcon(key: String): IIcon = Icon.valueOf(key)

    enum class Icon constructor(override val character: Char) : IIcon {
        //Octicons
        oct_alert('\ue900'),
        oct_archive('\ue901'),
        oct_arrow_both('\ue902'),
        oct_arrow_down('\ue905'),
        oct_arrow_down_left('\ue903'),
        oct_arrow_down_right('\ue904'),
        oct_arrow_left('\ue906'),
        oct_arrow_right('\ue907'),
        oct_arrow_switch('\ue908'),
        oct_arrow_up('\ue90b'),
        oct_arrow_up_left('\ue909'),
        oct_arrow_up_right('\ue90a'),
        oct_beaker('\ue90c'),
        oct_bell('\ue90f'),
        oct_bell_fill('\ue90d'),
        oct_bell_slash('\ue90e'),
        oct_bold('\ue910'),
        oct_book('\ue911'),
        oct_bookmark('\ue915'),
        oct_bookmark_fill('\ue912'),
        oct_bookmark_slash('\ue914'),
        oct_bookmark_slash_fill('\ue913'),
        oct_briefcase('\ue916'),
        oct_broadcast('\ue917'),
        oct_calendar('\ue918'),
        oct_check('\ue91b'),
        oct_check_circle('\ue91a'),
        oct_check_circle_fill('\ue919'),
        oct_checklist('\ue91c'),
        oct_chevron_down('\ue91d'),
        oct_chevron_left('\ue91e'),
        oct_chevron_right('\ue91f'),
        oct_chevron_up('\ue920'),
        oct_circle('\ue922'),
        oct_circle_slash('\ue921'),
        oct_clippy('\ue923'),
        oct_clock('\ue924'),
        oct_code('\ue927'),
        oct_code_review('\ue925'),
        oct_code_square('\ue926'),
        oct_comment('\ue929'),
        oct_comment_discussion('\ue928'),
        oct_commit('\ue92a'),
        oct_container('\ue92b'),
        oct_copy('\ue92c'),
        oct_cpu('\ue92d'),
        oct_credit_card('\ue92e'),
        oct_cross_reference('\ue92f'),
        oct_dash('\ue930'),
        oct_database('\ue931'),
        oct_desktop_download('\ue932'),
        oct_device_camera_video('\ue933'),
        oct_device_desktop('\ue934'),
        oct_device_mobile('\ue935'),
        oct_diff('\ue936'),
        oct_dot('\ue938'),
        oct_dot_fill('\ue937'),
        oct_download('\ue939'),
        oct_eye('\ue93b'),
        oct_eye_closed('\ue93a'),
        oct_file('\ue945'),
        oct_file_binary('\ue93c'),
        oct_file_code('\ue93d'),
        oct_file_diff('\ue93e'),
        oct_file_directory('\ue940'),
        oct_file_directory_fill('\ue93f'),
        oct_file_media('\ue941'),
        oct_file_submodule('\ue942'),
        oct_file_symlink_file('\ue943'),
        oct_file_zip('\ue944'),
        oct_filter('\ue946'),
        oct_flame('\ue947'),
        oct_fold('\ue94a'),
        oct_fold_down('\ue948'),
        oct_fold_up('\ue949'),
        oct_gear('\ue94b'),
        oct_gift('\ue94c'),
        oct_git_branch('\ue94d'),
        oct_git_commit('\ue94e'),
        oct_git_compare('\ue94f'),
        oct_git_fork('\ue950'),
        oct_git_merge('\ue951'),
        oct_git_pull_request('\ue952'),
        oct_globe('\ue953'),
        oct_grabber('\ue954'),
        oct_graph('\ue955'),
        oct_heading('\ue956'),
        oct_heart('\ue958'),
        oct_heart_fill('\ue957'),
        oct_history('\ue959'),
        oct_home('\ue95b'),
        oct_home_fill('\ue95a'),
        oct_horizontal_rule('\ue95c'),
        oct_hourglass('\ue95d'),
        oct_hubot('\ue95e'),
        oct_image('\ue95f'),
        oct_inbox('\ue960'),
        oct_infinity('\ue961'),
        oct_info('\ue962'),
        oct_insights('\ue963'),
        oct_issue_closed('\ue964'),
        oct_issue_opened('\ue965'),
        oct_issue_reopened('\ue966'),
        oct_italic('\ue967'),
        oct_kebab_horizontal('\ue968'),
        oct_key('\ue969'),
        oct_law('\ue96a'),
        oct_light_bulb('\ue96b'),
        oct_link('\ue96d'),
        oct_link_external('\ue96c'),
        oct_list_ordered('\ue96e'),
        oct_list_unordered('\ue96f'),
        oct_location('\ue970'),
        oct_lock('\ue971'),
        oct_mail('\ue972'),
        oct_megaphone('\ue973'),
        oct_mention('\ue974'),
        oct_milestone('\ue975'),
        oct_mirror('\ue976'),
        oct_moon('\ue977'),
        oct_mortar_board('\ue978'),
        oct_mute('\ue979'),
        oct_no_entry('\ue97a'),
        oct_north_star('\ue97b'),
        oct_note('\ue97c'),
        oct_octoface('\ue97d'),
        oct_organization('\ue97e'),
        oct_package('\ue981'),
        oct_package_dependencies('\ue97f'),
        oct_package_dependents('\ue980'),
        oct_paper_airplane('\ue982'),
        oct_pencil('\ue983'),
        oct_people('\ue984'),
        oct_person('\ue985'),
        oct_pin('\ue986'),
        oct_play('\ue987'),
        oct_plug('\ue988'),
        oct_plus('\ue98a'),
        oct_plus_circle('\ue989'),
        oct_project('\ue98b'),
        oct_pulse('\ue98c'),
        oct_question('\ue98d'),
        oct_quote('\ue98e'),
        oct_reply('\ue98f'),
        oct_repo('\ue992'),
        oct_repo_push('\ue990'),
        oct_repo_template('\ue991'),
        oct_report('\ue993'),
        oct_rocket('\ue994'),
        oct_rss('\ue995'),
        oct_ruby('\ue996'),
        oct_screen_full('\ue997'),
        oct_screen_normal('\ue998'),
        oct_search('\ue999'),
        oct_server('\ue99a'),
        oct_share('\ue99c'),
        oct_share_android('\ue99b'),
        oct_shield('\ue9a0'),
        oct_shield_check('\ue99d'),
        oct_shield_lock('\ue99e'),
        oct_shield_x('\ue99f'),
        oct_sign_in('\ue9a1'),
        oct_sign_out('\ue9a2'),
        oct_skip('\ue9a3'),
        oct_smiley('\ue9a4'),
        oct_square('\ue9a6'),
        oct_square_fill('\ue9a5'),
        oct_squirrel('\ue9a7'),
        oct_star('\ue9a9'),
        oct_star_fill('\ue9a8'),
        oct_stop('\ue9aa'),
        oct_stopwatch('\ue9ab'),
        oct_sun('\ue9ac'),
        oct_sync('\ue9ad'),
        oct_tab('\ue9ae'),
        oct_tag('\ue9af'),
        oct_tasklist('\ue9b0'),
        oct_telescope('\ue9b1'),
        oct_terminal('\ue9b2'),
        oct_thumbsdown('\ue9b3'),
        oct_thumbsup('\ue9b4'),
        oct_tools('\ue9b5'),
        oct_trash('\ue9b6'),
        oct_triangle_down('\ue9b7'),
        oct_triangle_left('\ue9b8'),
        oct_triangle_right('\ue9b9'),
        oct_triangle_up('\ue9ba'),
        oct_typography('\ue9bb'),
        oct_unfold('\ue9bc'),
        oct_unlock('\ue9bd'),
        oct_unmute('\ue9be'),
        oct_unverified('\ue9bf'),
        oct_upload('\ue9c0'),
        oct_verified('\ue9c1'),
        oct_versions('\ue9c2'),
        oct_workflow('\ue9c3'),
        oct_x('\ue9c6'),
        oct_x_circle('\ue9c5'),
        oct_x_circle_fill('\ue9c4'),
        oct_zap('\ue9c7');

        override val typeface: ITypeface by lazy { Octicons }
    }
}
